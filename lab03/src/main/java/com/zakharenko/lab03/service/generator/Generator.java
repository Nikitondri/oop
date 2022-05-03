package com.zakharenko.lab03.service.generator;

import com.zakharenko.lab03.service.exception.ServiceException;

public interface Generator {
    void generateRandomDataToFile() throws ServiceException;

}
