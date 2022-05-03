package com.zakharenko.lab03.service.impl;

import com.zakharenko.lab03.entity.Client;
import com.zakharenko.lab03.entity.tariff.*;
import com.zakharenko.lab03.service.GeneratorService;
import com.zakharenko.lab03.service.generator.Names;
import com.zakharenko.lab03.service.generator.Tariffs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorServiceImpl implements GeneratorService {
    private final Random random = new Random();
    private static final int MAX_CLIENTS = 10;

    @Override
    public ChildTariff generateChildTariff() {
        return new ChildTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10,
                generateClient(),
                generateClient()
        );
    }

    @Override
    public PensionTariff generatePensionTariff() {
        return new PensionTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10,
                generateListClients()
        );
    }

    @Override
    public LimitTariff generateLimitTariff() {
        return new LimitTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10
        );
    }

    @Override
    public FullUnlimitedTariff generateFullUnlimitedTariff() {
        return new FullUnlimitedTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100
        );
    }

    @Override
    public UnlimitedInternetTariff generateUnlimitedInternetTariff() {
        return new UnlimitedInternetTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10
        );
    }

    @Override
    public UnlimitedMinTariff generateUnlimitedMinTariff() {
        return new UnlimitedMinTariff(
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                generateListClients(),
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(899)) + 100,
                (random.nextInt(1)) + 10,
                (random.nextInt(1)) + 10
        );
    }

    private Client generateClient() {
        return new Client(
                Names.getName(random.nextInt(Names.size())).name(),
                (long) (random.nextInt(8999999)) + 1000000,
                Tariffs.getTariff(random.nextInt(Tariffs.size())).name());
    }

    private List<Client> generateListClients() {
        List<Client> list = new ArrayList<>();
        for (int i = 0; i < (random.nextInt(MAX_CLIENTS)); i++) {
            list.add(generateClient());
        }
        return list;
    }
}
