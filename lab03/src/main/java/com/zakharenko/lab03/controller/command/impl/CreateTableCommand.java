package com.zakharenko.lab03.controller.command.impl;

import com.zakharenko.lab03.controller.command.Command;
import com.zakharenko.lab03.controller.enumeration.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTableCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Page.TABLE.getValue();
    }
}
