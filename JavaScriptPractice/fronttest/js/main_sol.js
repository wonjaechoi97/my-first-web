window.onload = function () {
  // localStorage 에서 질문 얻기.
  let question = localStorage.getItem("question");

  let pollBtnDiv = document.querySelector(".content-left-poll-btn");
  let pollViewDiv = document.querySelector(".content-left-poll");

  let pollContent;
  if (question) {
    // 투표 있다면.

  } else {
    // 투표 없다면
    pollContent = `진행 중인 투표가 없습니다.`;
    pollViewDiv.innerHTML = pollContent;

    pollBtnDiv.style.display = "";
    // pollViewDiv.style.display = "";
    pollViewDiv.setAttribute("style", "text-align: center; color: red; display: ")
  }

  document.querySelector("#btn-makepoll").addEventListener("click", function() {
    window.open("./makepoll.html", "mp", "width=550, height=350, top=100");
  });

}