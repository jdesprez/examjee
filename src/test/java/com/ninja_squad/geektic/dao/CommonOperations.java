package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class CommonOperations {
    public static final Operation DELETE_ALL_GEEK = deleteAllFrom("GEEK");
    
    public static final Operation DELETE_ALL_TABLE = sequenceOf(deleteAllFrom("CENTREINTERETGEEK"),deleteAllFrom("GEEK"), deleteAllFrom("CENTREINTERET"));

    public static final Operation INSERT_GEEK_DATA =
            sequenceOf(
                    insertInto("GEEK")
                            .columns("id", "nom", "prenom", "adrmail", "genre")
                            .values(1L, "des", "jrme", "jrmedesprez@gmail.com", "HOMME")
                            .values(2L, "toto", "titi", "toto.titi@gmail.com", "FEMME")
                            .values(3L, "Unautre", "homme", "homme@gmail.com", "HOMME")
                            .build());
    
    public static final Operation INSERT_PREFENRENCE_DATA =
            sequenceOf(
                    insertInto("CENTREINTERET")
                            .columns("id", "nom")
                            .values(1L, "Java")
                            .values(2L, "C#")
                            .build());
    
    public static final Operation INSERT_PREFENRENCE_GEEK_DATA = sequenceOf( insertInto("CENTREINTERETGEEK")
                            .columns("idcentreinteret", "idgeek")
                            .values(1L, 1L)
                            .values(2L, 1L)
                            .values(2L, 2L)
                            .values(1L, 3L)
                            .build());
};