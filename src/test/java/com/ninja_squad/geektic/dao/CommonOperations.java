package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class CommonOperations {
    public static final Operation DELETE_ALL = deleteAllFrom("GEEK");

    public static final Operation INSERT_REFERENCE_DATA =
            sequenceOf(
                    insertInto("GEEK")
                            .columns("id", "nom", "prenom", "adrmail", "genre")
                            .values(1L, "des", "jrme", "jrmedesprez@gmail.com", "HOMME")
                            .values(2L, "toto", "titi", "toto.titi@gmail.com", "FEMME")
                            .build());
};