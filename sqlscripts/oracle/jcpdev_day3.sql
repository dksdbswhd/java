CREATE TABLE tbl# (
	col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,
	col2 varchar2(10) NOT NULL,  -- CONSTRAINT Ű���� ���� 
	col3 varchar2(10),
	col4 number(3)
);   -- CREATE �� 1���� �����մϴ�.

INSERT INTO tbl#(col1) VALUES ('test1');  -- ���� : �������� ����
INSERT INTO tbl#(col1,col2) VALUES ('test1','test2');  --���� ����

-- DML �߿��� insert, update,delete �� ������ ���� ���� Ȯ��
SELECT * FROM tbl#;

-- alter table   ���̺�� [���泻��Ű����]  (���泻��)  
-- 1)�÷� �̸� ����                 �����̸� to ���ο� �̸�
-- ALTER TABLE tbl# RENAME COLUMN co12 TO col2;  

-- 2) �Ʒ� �÷� �߰��ϸ� ���� row(��)�鵵 ���� �߰��� �÷�5 �� �� 100
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); -- �� : �⺻�� 100
-- 2) �� �����Ŀ� ������ �߰��մϴ�.
INSERT INTO tbl#(col1,col2) VALUES ('�׽�Ʈ11','�׽�Ʈ');

-- ���� : col2 10����Ʈ �ʰ� -> �ѱ� 3����Ʈ �׿� 1����Ʈ 
-- INSERT INTO tbl#(col1,col2) VALUES ('�׽�Ʈ11','�׽�Ʈ22');

-- �÷��߰� : column6 �������ڿ�(20) �⺻�� 'guest' �� �����غ�����.
ALTER  TABLE tbl# ADD (column6 VARCHAR(20) DEFAULT 'guest');
-- �Ʒ� ������ �߰� �� Ȯ��
INSERT INTO tbl#(col1,col2) VALUES ('�Խ�Ʈ1','�Խ�Ʈ2');

-- 4) ���� �÷� ���� ����
ALTER TABLE tbl# MODIFY (col2 varchar2(50)); 

-- 5) �������� �߰� : ������ ����� ������ ������ ������ ���� �� �ִ� �����Դϴ�.
--    col3 ���� ������ �� null �� ������ �������� �����Ͽ� ����
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
--    ���� ? or ����? -> col4 ���������Ͱ� �������ǿ� �´� ���̴�.
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);

-- 7) �������� ����
ALTER TABLE tbl# DROP CONSTRAINT tbl#_notnull3;

-- �������� Ű������� not null �� null�� ������ ��
ALTER TABLE tbl# MODIFY COL2 VARCHAR2(50) NULL;

-- col3 ������ ��� ä�� �Ŀ� ����Ȯ�� �غ�����. null -> not null�� ����
ALTER TABLE tbl# MODIFY COL3 VARCHAR2(50) NOT NULL;

-- ((����))���̺��� �������� �̸� Ȯ���ϱ� : ����Ŭ�� �ý��� ���̺�
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;

SELECT * FROM tbl#;
-- [���泻��Ű����] : 
-- 1) *�÷� �̸� ���� : rename column 
-- 2) ���̺� �̸� ���� : rename to 
-- 3) *���ο� �÷� �߰� : add
-- 4) *�÷� ������ ���� ���� : modify
-- 5) *���� ���� �߰� : add constraint  
-- 6) ���� �÷� ���� : drop
-- 7) ���� ���� ���� ���� : drop constraint ���������̸�






