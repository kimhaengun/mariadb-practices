# mariadb-practices

##  DB ER다이어그램 확인하는법
홈 --> Database --> Reverse Engineer

ERD를 분석하면
employees(직원) , salaries(월급)
      1                     N
1:N 인 이유 --> 월급 인상 정보 = 1년마다 연봉 협상 histroy

to_date = '0000-00-00' 현재 진행중인 필드


## ERD
![image](https://user-images.githubusercontent.com/74044234/135549252-2ed7fd0a-540d-4687-aa3b-2108060cd6a7.png)
