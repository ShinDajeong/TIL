## Web Browser에 URL을 입력하면 무슨 일이 일어날까?



#### 1. Client / Server Architecture

- 브라우저에 www.google.com을 입력하고 enter를 누르면 client는 인터넷을 통해 Google server에게 request(요청)를 하고 그에 대한 response(응답)를 받는다
- 그렇다면 client는 Google server가 어디에 있는지 어떻게 알까? 바로 **DNS(Domain Name Server)**를 통해 알아낼 수 있다
- **DNS를 통해 IP주소를 찾을 수 있다** 



#### 2. DNS 작동원리

- ##### DNS Resolver는 가장 먼저 Root Name Server에서 url을 검색해본다. RootNameServer는 .com이라는 root name에 대한 TLD Name Server IP 주소를 알려준다

- TLD Name Server는 google.com에 대해 검색하여 Authoritative Name Server IP주소를 알아낸다

- Authoritative Name Server에서는 www.google.com를 검색하여 IP주소를 알아낸다 

- **DNS Resolver는 알아낸 IP주소를 client에게 반환해준다**

- IP주소가 필요할때마다 위의 과정을 거치는 것이 번거롭기 때문에 캐싱을 할 수 있다

  - DNS Cache : 매번 DNS와 통신하는 비용을 줄여주는 수단

  - 저장 위치 : 브라우저, 운영체제, 라우터, ISP(Internet Service Provider)

    ISP : 인터넷에 접속하는 수단을 제공하는 주체



#### 3. TCP 3 Way Handshake

- 주소를 알아내면 TCP(Transmission Control Protocol) 세션 연결을 한다
  1. A클라이언트는 B서버에 접속을 요청하는 SYN 패킷을 보낸다
  2. B서버는 SYN요청을 받고 A클라이언트에게 요청을 수락한다는 ACK와 SYN flag가 설정된 패킷을 발송한다
  3. A클라이언트는 B서버에게 ACK를 보내고 그 이후로는 연결이 이루어지고 데이터가 오가게 된다



#### 4. HTTP request, response

- 연결이 완료되었으므로 HTTP 프로토콜에 따라 요청을 하고 응답을 받는다
- client가 get mothod로 요청을 하면 server가 index.html을 응답으로 보낸다 그 후 우리는 화면에서 google 메인 화면을 볼 수 있다



#### * 정리 *

1. 브라우저에 www.google..com 입력
2. DNS를 통해 IP 주소 획득
3. IP 주소에 있는 서버와 TCP 3 way handshake 진행
4. 통신을 맺은 서버에 http request
5. 서버에서 보낸 http response를 통해 html 파일을 받는다
6. 브라우저가 html를 분석해서 화면으로 그린다(렌더링)

