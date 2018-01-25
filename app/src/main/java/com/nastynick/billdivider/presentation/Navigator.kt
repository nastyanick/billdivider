package com.nastynick.billdivider.presentation

import ru.terrakok.cicerone.commands.Command


abstract class Navigator : ru.terrakok.cicerone.Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) {
            applyCommand(command)
        }
    }

    abstract fun applyCommand(command: Any)
}