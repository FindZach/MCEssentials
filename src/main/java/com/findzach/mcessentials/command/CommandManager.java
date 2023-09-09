package com.findzach.mcessentials.command;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class CommandManager {

    private static CommandManager instance = new CommandManager();
    private Map<String, Command> commandMap = new HashMap<>();
    private Map<String, SubCommand> subCommandMap = new HashMap<>();

    private EssentialsCommandExecutor essentialsCommandExecutor;
    public CommandManager() {
        // Dynamically load classes with the CommandInfo annotation
        Reflections reflections = new Reflections("com.findzach.mcessentials.command.impl");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(CommandInfo.class);
        essentialsCommandExecutor = new EssentialsCommandExecutor(this);

        for (Class<?> clazz : annotated) {
            try {
                CommandInfo info = clazz.getAnnotation(CommandInfo.class);

                if (clazz.newInstance() instanceof Command) {
                Command commandInstance = (Command) clazz.newInstance();

                if (info == null || info.name().isBlank()) continue;

                registerCommand(info.name(), commandInstance);
                MCEssentials.getInstance().getCommand(info.name()).setExecutor(essentialsCommandExecutor);

                } else {

                    if (info.commandType() == CommandType.SUB_COMMAND) {
                        System.out.println("Register name: " + info.name());
                        registerSubCommand(info.name(), (SubCommand) clazz.newInstance());
                    }
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeCommand(CommandSender sender, String name, String[] args) {
        Optional<Command> command = getCommand(name);
        if(command.isPresent() && sender.hasPermission(command.get().getPermission())) {
            command.get().execute(sender, args);
        }
    }

    private void registerCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    private void registerSubCommand(String name, SubCommand command) {
        subCommandMap.put(name, command);
    }

    public Optional<Command> getCommand(String name) {
        return Optional.ofNullable(commandMap.get(name));
    }

    public static CommandManager getInstance() {
        return instance;
    }
}
