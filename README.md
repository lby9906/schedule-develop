# CH5 일정 관리 앱 - Develop
> **개발 기간 : 2025.08.05 ~ 2025.08.14**

## 💁‍♀ 일정 관리 앱 - Develop 소개
> - 3 Layer Architecture에 따라 각 Layer의 목적에 맞게 개발한 일정 관리 앱입니다.</br>
> - JAVA + SpringBoot + JPA + MYSQL을 사용하여 개발하였습니다.
> - 인증/인가 절차는 Cookie/Session을 활용하여 개발하였습니다.
> - JPA 연관관계를 통한 테이블을 설계하였습니다.

## 🛠️ 주요 기능

- 로그인
- 회원
    - 회원 생성 : 회원가입(비밀번호 암호화)
    - 회원 조회 : 회원 상세 조회
    - 회원 수정 : 회원 이름 및 이메일 수정
    - 회원 삭제 : 회원 삭제
- 일정
    - 일정 생성 : 일정 등록
    - 일정 조회 : 전체(작성자 명 조건 여부) / 단건 조회(일정 ID)
    - 일정 수정 : 일정 제목 및 작성자명만 수정
    - 일정 삭제 : 일정 삭제
- 댓글
    - 댓글 생성 : 댓글 등록
    - 댓글 조회 : 댓글 전체 조회
    - 댓글 수정 : 댓글 내용 수정
    - 댓글 삭제 : 댓글 삭제

## 🗒️ API 명세서
> https://documenter.getpostman.com/view/25131614/2sB3BEoAmz

## 📚 ERD
<img width="513" height="600" alt="Image" src="https://github.com/user-attachments/assets/6dea70cb-f095-4e15-bac6-4d2c5803f3b9" />
