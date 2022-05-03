package com.zakharenko.lab03.controller.command.impl;

import com.zakharenko.lab03.controller.command.Command;
import com.zakharenko.lab03.controller.enumeration.Page;
import com.zakharenko.lab03.service.TariffService;
import com.zakharenko.lab03.service.exception.ServiceException;
import com.zakharenko.lab03.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveTariffCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TariffService tariffService = ServiceFactory.getInstance().getTariffService();
        try {
            tariffService.removeTariff(request);
            return Page.TABLE.getValue();
        } catch (ServiceException e) {
            return Page.ERROR.getValue();
        }
    }
}
