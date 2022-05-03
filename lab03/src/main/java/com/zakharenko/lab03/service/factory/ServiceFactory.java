package com.zakharenko.lab03.service.factory;

import com.zakharenko.lab03.service.GeneratorService;
import com.zakharenko.lab03.service.TariffService;
import com.zakharenko.lab03.service.impl.GeneratorServiceImpl;
import com.zakharenko.lab03.service.impl.TariffServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TariffService tariffService = new TariffServiceImpl();
    private final GeneratorService generatorService = new GeneratorServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TariffService getTariffService(){
        return tariffService;
    }

    public GeneratorService getGeneratorService() {
        return generatorService;
    }
}
