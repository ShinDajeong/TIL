### SFC(Single File Component)

- **component** : 다시 사용할 수 있는 범용성을 위해 개발된 소프트웨어 구성 요소
- Vue 컴포넌트는 Vue 인스턴스이기도 하다
- 유지, 보수, 재사용성
- **SFC** : 화면의 특정 영역에 대한 html, css, javascript 코드를 하나의 파일(.vue)에서 관리

### Vue CLI

- npm : js 프로그래밍 언어를 위한 패키지 관리자.  node.js 기본 패키지 관리자
- vue cli : 빠르게 vue.js를 개발하기 위한 command line interface

### Babel & Webpack

- **node.js** ? javascript를 브라우저 밖에서 실행 할 수 있는 새로운 환경
- **Babel** ? javascript compiler
- 파편된(크로스 브라우징 이슈) javascript 문법을 변환하기 위해 존재하는 도구
- 최신문법을 이전문법으로 번역해주는 번역기
- **Webpack** ? 모듈간의 의존성 문제를 해결하기 위해 존재하는 도구

### ROUTER

- <router-view> : 라우팅이 경로에 따라 컴포넌트를 바꿔치기해서 렌더링할 때 렌더링하는 부분
- https://router.vuejs.org/kr/guide/

### Pass Props & Emit Events

- 모든 prop들은 부모와 자식사이에 단방향으로 내려가는 바인딩 형태를 취한다
- 모든 데이터는 자식에서 부모로 흐른다
- 자식은 부모에게 event 발생을 알려준다 (data와 함께)

### Axios

- https://github.com/axios/axios
- axios.get(url, {params}).then((res)⇒{}).catch((err)⇒{}) / 성공, 실패

API_KEY는 보안적인 문제때문에 프로젝트 상단 root에서 파일을 만든다 (.env.local) 파일에서 key=value 쌍으로 입력한다

key ⇒ vue에서 쓴다면 VUE_APP_내마음대로짓기

### Vue Instance 속성

- el : Vue가 적용될 요소 지정. CSS Selector or HTML Element
- data : Vue에서 사용되는 정보 저장. 객체 또는 함수의 형태
- template : 화면에 표시할 HTML, CSS 등의 마크업 요소를 정의하는 속성으로 뷰의 데이터 및 기타 속성들도 함께 화면에 그릴 수 있다
- methods : 화면 로직 제어와 관계된 method를 정의하는 속성. 마우스 클릭 이벤트 처리와 같이 화면의 전반적인 이벤트와 홤녀 동작과 관련된 로직을 추가
- created : 뷰 인스턴스가 생성되자 마자 실행할 로직을 정의