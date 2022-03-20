window.onload = function () {
  document.getElementById("btn-add").addEventListener("click", function () {
    let pollAnswerList = document.getElementById("poll-answer-list");

    let divEl = document.createElement("div");
    divEl.setAttribute("class", "poll-answer-item");

    let inputEl = document.createElement("input");
    inputEl.setAttribute("type", "text");
    inputEl.setAttribute("name", "answer");

    let btnEl = document.createElement("button");
    btnEl.setAttribute("class", "button");
    btnEl.setAttribute("type", "button");
    btnEl.appendChild(document.createTextNode("삭제"));
    btnEl.addEventListener("click", function () {
      pollAnswerList.removeChild(btnEl.parentElement);
    });

    divEl.appendChild(inputEl);
    divEl.appendChild(btnEl);

    pollAnswerList.appendChild(divEl);
  });

  document.querySelector("#btn-make").addEventListener("click", function () {
    console.log(2);
    let question = document.getElementById("question").value;
    if (!question) {
      alert("질문 내용을 입력하세요!");
      return;
    }

    //유효성 검사
    let answers = document.getElementsByName("answer");
    for (let answer of answers) {
      if (!answer.value) {
        alert("답변항목을 입력하세요!");
        return;
      }
    }

    let answerArr = [];
    for (let answer of answers) {
      answerArr.push(answer.value);
    }
    if (confirm("투표를 생성하시겠습니까?")) {
      localStorage.setItem("question", question);
      localStorage.setItem("answers", JSON.stringify(answerArr));

      opener.location.reload();
      self.close();
    }
  });
};
