-- java�� �����ϸ鼭 �ʿ��� sql �׽�Ʈ �մϴ�.

-- ����ڰ� ��ϵɶ� �Է��� id �ߺ����� �ִ��� �˻�����.
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- ���� �� ��� ���ϰ� 1
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- ���� �� ��� ���ϰ� 0


SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- ���� �� ��� ��(row) 1�� ��ȸ
SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- ���� �� ��� ��(row) ����
--                 �� �ڹٿ����� ��ȸ�� ����� null ����? ���� �˻��Ͽ� Ȯ���մϴ�.


-- ��� �� ��ȸ�ϴ� select ���� ���� �ڹٿ��� �ڵ��� �غ��ϴ�. �׸��� ���� �Ϳ� �����մϴ�.

SELECT * FROM CUSTOM#; 

--custom_id �÷��� PK -> �ߺ����� ����. -> 1�� �Ǵ� 0�� row ��ȸ�˴ϴ�.
SELECT * FROM CUSTOM# WHERE custom_id = 'momo';    

SELECT * FROM CUSTOM# WHERE age= 25 ;    -- age �ߺ����� ���� �÷� -> ��ȸ�� ROW ���� 0��,1��,2�� �̻�