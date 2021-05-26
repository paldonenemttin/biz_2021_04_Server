# TODO List 프로젝트

## From Controller 패턴
* 각 path(URL)마다 Servlet을 작성하는 기존의 프로젝트를 변경
* 1개의 Servlet Controller에서 모든요청을 수신하고
* 각각의 path에 따라 다른 클래스를 호출하여 실행하기

## Commend 패턴
* Servlet에서 처리할 요청을 Commend 클래스를 생성하여  
요청의 응답을 대신 수행하도록 하는 패턴

## pom.xml 상속받기
* pom.xml이 완성된 maven 프로젝트의 package를 pom으로 바꾸기
* maven buld를 이용하여 repo에 프로젝트 install하기
* 실제 프로젝트에서 parenr tag를 히용하여 pom.xml을 상속받아서 사용