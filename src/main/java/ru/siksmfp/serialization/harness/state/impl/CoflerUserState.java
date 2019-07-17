package ru.siksmfp.serialization.harness.state.impl;

import ru.siksmfp.serialization.harness.model.cofler.Address;
import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.state.StateConstant;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_2;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_3;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_4;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.SIGNATURE;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_POPULATION;

public class CoflerUserState implements BenchmarkState {

    public User user;
    public byte[] serializedUser;

    @Override
    public void setUp() {
        user = new User();
        serializedUser = new byte[1024];

        user.setId(ID_1);
        user.setName(StateConstant.NAME);
        user.setSignature(SIGNATURE);

        Address address1 = new Address();
        address1.setId(ID_1);
        address1.setCity(MOSCOW_CITY);
        address1.setPopulation(MOSCOW_POPULATION);

        Address address2 = new Address();
        address2.setId(ID_2);
        address2.setCity(SPB_CITY);
        address2.setPopulation(SPB_POPULATION);

        Address address3 = new Address();
        address3.setId(ID_3);
        address3.setCity(DZRERZHINSK_CITY);
        address3.setPopulation(DZRERZHINSK_POPULATION);

        Address address4 = new Address();
        address4.setId(ID_4);
        address4.setCity(VLADIVASTOK_CITY);
        address4.setPopulation(VLADIVASTOK_POPULATION);

        Address address5 = new Address();
        address5.setId(ID_5);
        address5.setCity(TOKIO_CITY);
        address5.setPopulation(TOKIO_POPULATION);

        user.setAddresses(new Address[]{address1, address2, address3, address4, address5});
        user.marshal(serializedUser, 0);
    }
}
