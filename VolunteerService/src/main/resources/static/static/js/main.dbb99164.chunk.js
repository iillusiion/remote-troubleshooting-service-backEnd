(this.webpackJsonpmyfrontend=this.webpackJsonpmyfrontend||[]).push([[0],{11:function(e,t,n){e.exports=n(19)},16:function(e,t,n){},18:function(e,t,n){},19:function(e,t,n){"use strict";n.r(t);var a=n(0),o=n.n(a),r=n(3),i=n.n(r),c=(n(16),n(1)),s=n.n(c),l=n(4),u=n(5),g=n(6),h=n(9),d=n(7),m=n(10),p=n(8),f=n.n(p),v=(n(18),function(e){function t(e){var n;return Object(u.a)(this,t),(n=Object(h.a)(this,Object(d.a)(t).call(this,e))).handleClick=function(){var e=Object(l.a)(s.a.mark((function e(t){var a,o;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t.preventDefault(),console.log("Clike"),e.next=4,fetch("/greeting?name="+n.state.greeting);case 4:return a=e.sent,e.next=7,a.json();case 7:o=e.sent,n.setState({greeting:o.name,isLoading:!1,isGreetingVisible:""});case 9:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),n.state={value:"random text",greeting:"",isLoading:!1},n}return Object(m.a)(t,e),Object(g.a)(t,[{key:"handleChange",value:function(e){console.log("handle change called"),console.log(this.state.greeting),console.log(this.state.isLoading),this.setState({greeting:e.target.value,isLoading:!1})}},{key:"render",value:function(){var e=this;return o.a.createElement("div",{className:"App"},o.a.createElement("header",{className:"App-header"},o.a.createElement("img",{src:f.a,className:"App-logo",alt:"logo"}),o.a.createElement("div",{className:"App-intro"},o.a.createElement("input",{onChange:function(t){e.handleChange(t)},placeholder:"Enter Your Name"}),o.a.createElement("button",{onClick:this.handleClick},"Please Click Me!"),o.a.createElement("h2",null,"Hello ",this.state.greeting))))}}]),t}(o.a.Component));Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));i.a.render(o.a.createElement(v,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))},8:function(e,t,n){e.exports=n.p+"static/media/logo.25bf045c.svg"}},[[11,1,2]]]);
//# sourceMappingURL=main.dbb99164.chunk.js.map