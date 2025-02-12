## 프로젝트 설명

정수원 시큐리티 + OAuth 강의를 수강하던 중, 더 원활한 이해를 위해 시작하게 됐다.<br/>
유튜버 유미 시큐리티 실습으로 시큐리티 활용법과 전반적인 흐름을 먼저 파악해보기로 했다.<br/>
[유미 강의 링크](https://www.youtube.com/playlist?list=PLJkjrxxiBSFCKD9TRKDYn7IE96K2u3C3U) <- 얘가 좀 짧고 하루 컷하기 좋음
<br/><br/>

---
### 강의와 다르게 진행한 부분과 그 이유

1. 템플릿 엔진 mustache 대신 thymeleaf 사용
    - 표현식이 더 풍부한 데다, html이 더 익숙하고 문법을 알고 있기 때문이다.
    - 또한 thymeleaf는 [스프링이 적극 추천하는 템플릿](https://docs.spring.io/spring-framework/reference/web/webmvc-view/mvc-thymeleaf.html)이기도 하다.
2. mysql 대신 postgresql 사용
    - 둘 다 비슷하나, 시큐리티 공부가 메인이니 오류가 발생해도 내가 쉽게 대처 가능한 postgresql로 결정했다.
    - GUI(pgAdmin 4) 툴이 mysql 대비 훨씬 깔끔하다.
    - 그리고 원래 강의랑 좀 다르게 진행해야 더 재밌다.
3. 필드 주입 대신 생성자 주입으로 개선
4. 일부 코드 및 구조 개선
5. 적당한 css 추가
    - 구린 디자인을 볼 수 없는 불치병이 있기 때문이다.
<br/><br/>

---
### 스크린샷

#### 1. 메인 화면 (ANONYMOUS / USER / ADMIN)
사용자에 따라 달라지는 인사말과 함께 랜덤 이미지들을 보여준다.<br/>
<img src="https://github.com/user-attachments/assets/a8385503-82a4-4a60-b520-b96e4bad8bfd" width="300"/>
<img src="https://github.com/user-attachments/assets/f92af6ee-5361-4208-bcf1-ec56864f3832" width="300"/>
<img src="https://github.com/user-attachments/assets/24d5f62d-ae46-4cb0-bb2f-016ec740901e" width="300"/>
<br/><br/>

#### 2. 로그인 화면
<img src="https://github.com/user-attachments/assets/ade4bcc0-2cbc-41b3-879d-9b7decb964a9" width="400"/>
<br/><br/>

#### 3. 회원가입 화면
<img src="https://github.com/user-attachments/assets/4f5db090-2af1-4c84-b911-1b5f43f5129e" width="400"/>
<img src="https://github.com/user-attachments/assets/02c25185-b60f-4341-a96f-c9ec218c7ea9" width="400"/>
<br/><br/>

#### 4. 회원 테이블 목록 (회원가입 후 db 저장)
<img src="https://github.com/user-attachments/assets/07fcef79-3a3e-4a9a-9b0b-899d8202d45e" width="900"/>
<br/><br/>

#### 5. ADMIN 권한이 필요한 관리 페이지 (ANONYMOUS / USER / ADMIN)
<img src="https://github.com/user-attachments/assets/8cde3a83-dc06-476d-b9b4-139545ad52f5" width="300"/>
<img src="https://github.com/user-attachments/assets/216a49bd-60df-4b1d-ba86-e2aeb2b0c0a3" width="300"/>
<img src="https://github.com/user-attachments/assets/ad582b01-c83a-4039-9570-905d9ee3d9db" width="300"/>
<br/><br/>

#### 6. USER 권한 이상 접근 가능한 마이페이지 (ANONYMOUS / USER / ADMIN)
<img src="https://github.com/user-attachments/assets/f6118ce6-a574-488e-b309-26fd3882ee8e" width="300"/>
<img src="https://github.com/user-attachments/assets/beaa5542-4c0f-4138-b391-db30ff9f29cc" width="300"/>
<img src="https://github.com/user-attachments/assets/f44d6c43-cd81-4d43-a438-dcca4a791fed" width="300"/>
<br/><br/>
