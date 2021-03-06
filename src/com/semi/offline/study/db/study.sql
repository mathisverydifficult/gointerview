--오프라인 스터디모임 게시판
--DROP 트리거, 시퀀스, 테이블
DROP TRIGGER TB_STUDY_AI_TRG;
DROP SEQUENCE TB_STUDY_SEQ;
DROP TABLE TB_STUDY;
--CREATE 테이블, 시퀀스, 트리거
CREATE TABLE TB_STUDY
(
    STD_SEQ         NUMBER            NOT NULL, 
    STD_TITLE       VARCHAR2(100)     NOT NULL, 
    STD_CONTENTS    VARCHAR2(1000)    NOT NULL, 
    STD_DT          DATE              NOT NULL, 
    STD_ID          VARCHAR2(20)      NOT NULL, 
    STD_STAT        VARCHAR2(20)      NOT NULL, 
    STD_SHOW_YN     CHAR(1)           NOT NULL, 
    STD_MBR_NUM     NUMBER            NOT NULL, 
    CONSTRAINT TB_STUDY_PK PRIMARY KEY (STD_SEQ)
);

CREATE SEQUENCE TB_STUDY_SEQ;

CREATE OR REPLACE TRIGGER TB_STUDY_AI_TRG
BEFORE INSERT ON TB_STUDY 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT TB_STUDY_SEQ.NEXTVAL
    INTO :NEW.STD_SEQ
    FROM DUAL;
END;

INSERT INTO TB_STUDY VALUES(1,'뭐냐구젠장','왤케어려워','202001150900','kh','copy','y',9);
INSERT INTO TB_STUDY VALUES(1,'뭐냐고젠장','왤케어ㅇㄹ려워','202001150910','kh','co2py','y',9);
INSERT INTO TB_STUDY VALUES(1,'뭐나교젠장','왤케어ㅇㄹㅇㄹ려워','202001150915','kh','co2py','y',9);