## Vue.js ?

> 웹 애플리케이션의 사용자 인터페이스를 만들기 위해 사용하는 프로그레시브 자바스크립트 프레임워크

### CSR(Client Side Rendering)

클라이언트 사이드 렌더링은 SPA로, 클라이언트 사이드에서 HTML을 반환한 후에, JS가 동작하면서 데이터만을 주고 받아서 클라이언트에서 렌더링을 진행하는 것

### SPA(Single Page Application)

서버로부터 완전한 새로운 페이지를 불러오지 않고 현재의 페이지를 동적으로 다시 작성함으로써 사용자와 소통하는 웹 애플리케이션

### Why Vue.js?

Reactive : 데이터가 변경되면 DOM이 알아서 다시 렌더링 해준다

### MVVM (Model / View / ViewModel)

1. Model : Javascript의 Object
2. View : DOM(HTML)
3. ViewModel : 모든 Vue Instance (모델과 뷰 연결)

```html
// 뷰를 사용하기 위해 개발버전을 CDN으로 불러온다
const app = new Vue({
	el: '#app',
	data: {
		// 이 내용은 DOM에서 {{ }} 로 확인 가능
	},
	methods:{
		// DOM에서 사용하는 함수들을 넣어줌
	}
});
```

### Vue Directive

- v-for
- v-if, v-else-if, v-else
- v-bind : 데이터 바인딩 → v-bind:클래스 or html표준속성="데이터속성" → : 으로 단축가능
- v-on : 이벤트 핸들링 → @ 로 단축가능 ex) click, keyup.enter 등등
- v-model : 양방향 데이터 바인딩
- v-text : {{ }}와 동일
- v-html : 태그 자체가 텍스트형태로 렌더링
- v-show : v-if와 동작이 거의 비슷
- v-show와 v-if의 차이점 : v-if는 조건에 안맞으면 렌더링 자체를 안한다. 그러나 v-show는 렌더링을 하고 display 속성을 none으로 함