## 프로젝트 설명

정수원 시큐리티 + OAuth 강의를 수강하던 중, 더 원활한 이해를 위해 시작하게 됐다.<br/>
유튜버 유미 시큐리티 실습으로 시큐리티 활용법과 전반적인 흐름을 먼저 파악해보기로 했다.<br/>
[유미 강의 링크](https://www.youtube.com/playlist?list=PLJkjrxxiBSFCKD9TRKDYn7IE96K2u3C3U) <- 얘가 좀 짧고 하루 컷하기 좋음
<br/><br/>

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
