SET mode ORACLE;

CREATE TABLE TUTOR (
    id int primary key
    , nome varchar
    , nascimento date
    , cpf varchar
    , email varchar);

CREATE TABLE ANIMAL (
    id int primary key
    , id_tutor int
    , nome varchar
    , nascimento date
    , sexo int
    , CONSTRAINT fk_tutor_idtutor
        foreign key (id_tutor) references tutor(id));


CREATE SEQUENCE tutor_sequence
    START WITH 10000
    INCREMENT BY 5
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE animal_sequence
    START WITH 1000
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- TUTOR
-- INSERT INTO TUTOR (id, nome, nascimento, cpf, email) 
--     VALUES (
--         0
--         , 'Indefinido'
--         , Null
--         , Null
--         , Null
--     );

INSERT INTO TUTOR (id, nome, nascimento, cpf, email) 
    VALUES (
        tutor_sequence.NEXTVAL
        , 'Christiano Machado da Costa'
        , '1997-12-17'
        , '05734977373'
        , 'christianomachdo10@gmail.com'
    );

INSERT INTO TUTOR (id, nome, nascimento, cpf, email) 
VALUES (
    tutor_sequence.NEXTVAL
    , 'Francisco Valderley Lopes Machado'
    , '1960-07-02'
    , '21413223320'
    , 'valderleylopesmachado@gmail.com'
);


-- ANIMAL

INSERT INTO ANIMAL (id, id_tutor, nome, nascimento, sexo) 
    VALUES (
        animal_sequence.NEXTVAL
        , tutor_sequence.CURRVAL
        , 'Silon'
        , '2012-01-01'
        , 1);

INSERT INTO ANIMAL (id, id_tutor, nome, nascimento, sexo) 
    VALUES (
        animal_sequence.NEXTVAL
        , tutor_sequence.CURRVAL
        , 'Bidu'
        , '2010-01-01'
        , 1);

INSERT INTO ANIMAL (id, id_tutor, nome, nascimento, sexo) 
    VALUES (
        animal_sequence.NEXTVAL
        , tutor_sequence.CURRVAL
        , 'Nnah'
        , '2012-01-01'
        , 0);
