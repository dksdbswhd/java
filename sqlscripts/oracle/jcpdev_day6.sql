-- java�� �����ϸ鼭 �ʿ��� sql �׽�Ʈ �մϴ�.

-- ����ڰ� ��ϵɶ� �Է��� id �ߺ����� �ִ��� �˻�����.
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- ���� �� ��� ���ϰ� 1
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- ���� �� ��� ���ϰ� 0


SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- ���� �� ��� ��(row) 1�� ��ȸ
SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- ���� �� ��� ��(row) ����
--                 �� �ڹٿ����� ��ȸ�� ����� null ����? ���� �˻��Ͽ� Ȯ���մϴ�.


-- ��� �� ��ȸ�ϴ� select ���� ���� �ڹٿ��� �ڵ��� �غ��ϴ�. �׸��� ���� �Ϳ� �����մϴ�.