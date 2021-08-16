/*
SQL ����(select) ���� ����

1. custom# ���̺��� age �� 25�� �̻� ��� ���� ��ȸ
2. custom# ���̺��� custom_id 'momo' �� email ��ȸ
3. product# ���̺��� category '12' �� pname ��ȸ
4. product# ���̺��� price �� �ְ� ��ȸ
5. product# ���̺��� category '10' �� ���� ��ȸ
6. buy# ���̺��� custom_id 'nayeon' �� ��� ���� ��ȸ
7. buy# ���̺��� pcode �� 'LG'�� �����ϴ� �� ��ȸ
8. buy# ���̺��� cusom_id 'momo' �� ������ ��ǰ�� �̸��� ���� ��ȸ(�������� ���)

*/

-- 11�� 30�б��� ���� �����ϰ� ���� ����� ������.(����: �̸��� koreait.2021@gmail.com) �̿ϼ��ص� ����.


-- Ǯ��

--1. custom# ���̺��� age �� 25�� �̻� ��� ���� ��ȸ
SELECT * FROM "CUSTOM#" WHERE age >=25;

--2. custom# ���̺��� custom_id 'momo' �� email ��ȸ
SELECT EMAIL FROM "CUSTOM#" WHERE CUSTOM_ID ='momo';

--3. product# ���̺��� category '12' �� pname ��ȸ
SELECT pname FROM "PRODUCT#"  WHERE CATEGORY ='12';

--4. product# ���̺��� price �� �ְ� ��ȸ
SELECT MAX(PRICE) FROM "PRODUCT#";

--5. product# ���̺��� category '10' �� ���� ��ȸ
SELECT count(*) FROM "PRODUCT#" WHERE CATEGORY ='10';

--6. buy# ���̺��� custom_id 'nayeon' �� ��� ���� ��ȸ
SELECT * FROM buy# WHERE CUSTOM_ID ='nayeon';

--7. buy# ���̺��� pcode �� 'LG'�� �����ϴ� �� ��ȸ
SELECT * FROM buy# WHERE PCODE LIKE 'LG%';

--8. buy# ���̺��� cusom_id 'momo' �� ������ ��ǰ�� �̸��� ���� ��ȸ(�������� ���)
--  buy# ���̺��� ��ǰ ������ ���� ��ID�� ������ ����� �� �ֽ��ϴ�. 
SELECT  PNAME,PRICE FROM "PRODUCT#" 
		WHERE PCODE IN (SELECT PCODE FROM "BUY#" WHERE CUSTOM_ID ='nayeon');

SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='nayeon';
SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='momo';

SELECT PNAME,PRICE FROM "PRODUCT#" WHERE PCODE = 'MU98';


-- JOIN : �� �̻��� ���̺��� �����ϳ� �����͸� �˻��ϴ� ���.
--		  �� ���� ���̺� ����� �÷��� ����Ѵ�.
-- ���� ���� (���� ����) : ���� ���  buy# , product# ���̺��� �����ϸ�

-- ���� from ���̺�1 a,���̺�2 b where a.�ߺ��÷�1 = b.�ߺ��÷�1 : a,b���̺��� ���� ��������(�������輳���ķ����)

SELECT * FROM buy#, product# WHERE buy#.pcode = product#.pcode;      
-- �� �⺻�������� ���� Ȯ��

--SELECT pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;  -- ���� �� Ư���÷� ����

SELECT buy#.pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;

-- ���̺��, �÷����� alias (��Ī)�� �����մϴ�. -> �̸��� �����ϰ� �մϴ�.

-- buy# ���̺��� pcode ������ price �� �˰� �ʹ�. PCODE = 'MU98'
-- buy# ���̺��� ���� ���  buy_no ���� ���űݾ� ��� : price * quantity(����)
SELECT CUSTOM_ID , b.pcode,pname,price,quantity , price*quantity AS total  -- �÷����� AS �ᵵ �˴ϴ�.
		FROM buy# b, product# p        -- ����Ŭ�� ���̺�� �ڿ� AS �Ⱦ��ϴ�.
		WHERE b.pcode = p.pcode;    -- AS�� ������ �����ϰ� ���ϴ�.

SELECT CUSTOM_ID , b.pcode,pname, price,quantity , price*quantity total 
		FROM buy# b, product# p 
		WHERE b.pcode = p.pcode AND b.pcode = 'MU98'; 
 


SELECT * FROM "BUY#";


-- ���� ������ ����� �׷�ȭ 
--       ��  1.���� �� ���űݾ� -> sum(total) -> group by custom_id(FK)
--       ��  2.��ǰ�� �� �Ǹűݾ� -> sum(total) -> group by pcode(FK)

WITH sale as(  -- �ӽ����̺� -> �� �ѹ� ��� �մϴ�.�̸��� sale
	SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		   price*quantity AS total  -- �÷����� AS �ᵵ �˴ϴ�.
	FROM buy# b, product# p        -- ����Ŭ�� ���̺�� �ڿ� AS �Ⱦ��ϴ�.
	WHERE b.pcode = p.pcode
)












