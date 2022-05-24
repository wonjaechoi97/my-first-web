# MVC
 > ## MVC 
 >  사용자가 서버에게 작업을 요청하면 controller가 모델에게 어떻게 로직을 처리할지 알려주면서 일을 시킨다. 모델이 비지니스 로직을 처리한 결과를 다시 controller에게 전달하고 controller는 시각적인 표현을 담당하는 view를 제어해서 사용자에게 전달한다.  세 구성 요소가 각자의 맡은 일을 하게 분리하여 유지 보수를 편리하게 할 수 있다.
 >   
 > ## Model
 > 애플리케이션의 정보 데이터를 나타낸다. 데이터 베이스에 대한 접근 , 데이터에 대한 처리 가공 등 내부 비지니스 로직을 처리하는 컴포넌트 이다. 
 > 
 >  ## View 
 > 클라이언트의 화면에 보여주는 역할을 수행한다. 컨트롤러가 보여주고자 하는 것을 보여준다. 
 > 
 > ## Controller
 > 클라이언트가 요청한 작업을 분석해서 어떻게 처리할지 모델에게 알려주는 역할을 수행한다. 또한 모델일 처리한 결과를 바탕으로 view를 업데이트한다. 
 > 