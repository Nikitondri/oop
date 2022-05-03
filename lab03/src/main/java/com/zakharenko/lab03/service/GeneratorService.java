package com.zakharenko.lab03.service;

import com.zakharenko.lab03.entity.tariff.*;

public interface GeneratorService {
    ChildTariff generateChildTariff();
    PensionTariff generatePensionTariff();
    LimitTariff generateLimitTariff();
    FullUnlimitedTariff generateFullUnlimitedTariff();
    UnlimitedInternetTariff generateUnlimitedInternetTariff();
    UnlimitedMinTariff generateUnlimitedMinTariff();
}
