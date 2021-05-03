# Req And Res
* Reuest(요청), Response(응답)

* Run As / Run on Servcer로 실행하면
Tomcat이 서비스를 하기 위해 시작된다

* WebBrowser에서 localhost:8080/Server001_Hello와 같은 주로를 입력하고 Enter를 누르면

* localhost(내컴퓨터)의 8080 Port에서 기다리고 있는 Tomcat에게 요청을 한다

* tomcat은 /Server_001_Hello라는 프로젝트가 Run되어 있는지를 찾느다

* 있으면 프로젝트의 webapp 폴터에서
index.htm, index.html, index.jsp 파일ㅇ르 순서대로 찾는다

* 있으면 파일을 읽어서 web browser에 응답을 한다

* 없으면 404 vkdlf djqtdma,(fileNot found) 오류 메시지를 전송한다.

*localhost:8080/Server_001_Hello/index.html과 같은 방식으로 요청한 것으로 미리 약속되어 있다.