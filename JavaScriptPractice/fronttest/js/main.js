window.onload = function () {
  // localStorage 에서 질문 얻기.
  let question = localStorage.getItem("question");
  let answers = JSON.parse(localStorage.getItem("answers"));

  let pollBtnDiv = document.querySelector(".content-left-poll-btn");
  let pollViewDiv = document.querySelector(".content-left-poll");

  let pollContent;

  if (question) {
    pollContent = ``;
    pollContent += `<div class="poll-question">` + question + `</div>`;
    pollContent += `<div class="poll-answer"><ul>`;
    for (let answer of answers) {
      pollContent +=
        `<li>
      <input type="radio" name="district" />` +
        answer +
        `</li> 
      `;
    }
    pollContent += `</ul></div>`;
    pollViewDiv.innerHTML = pollContent;
    pollViewDiv.setAttribute("style", " display=''");
  } else {
    pollContent = `진행중인 투표가 없습니다.`;
    pollViewDiv.innerHTML = pollContent;
    pollViewDiv.setAttribute("style", "text-align:center;display: ");
    pollBtnDiv.style.display = "";
  }

  document
    .querySelector("#btn-makepoll")
    .addEventListener("click", function () {
      window.open(
        "./makepoll.html",
        "makepoll",
        "width=450, height=350, left=100, top=100  "
      );
    });
};
