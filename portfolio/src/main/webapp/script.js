// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;

    // Selecting the iframe element
    var iframe = document.getElementById("myIframe");

    // Adjusting the iframe height onload event
    iframe.onload = function(){
        iframe.style.height = iframe.contentWindow.document.body.scrollHeight + 'px';
    }
}

//////////////////////
/* Request content from the server and add it to the html page */
/*function requestContent() {

    fetch('/data').then(response => response.json()).then((someTexts) => {
        const statsListElement = document.getElementById('body');
        statsListElement.innerHTML = someTexts;
    });

}*/

/*function createCommentElement(comment) {
    // Build the list of history entries.
    const historyEl = document.getElementById('history');
    history.forEach((line) => {
        historyEl.appendChild(createListElement(line));
    });

    //taskElement.appendChild(historyEl);
    return historyEl;

}*/

/** Creates an <h2> element containing text. */
/*function createListElement(text) {
  const liElement = document.createElement('h2');
  liElement.innerText = text;
  return liElement;
}*/

/** Fetches tasks from the server and adds them to the DOM. */
function loadComments() {
  fetch('/comment-history').then(response => response.json()).then((commentsList) => {
    const commentListElement = document.getElementById('comment-list');
    commentsList.forEach((comment) => {
      commentListElement.appendChild(createCommentElement(comment));
    })
  });
}

/** Creates an element that represents a comment */
function createCommentElement(comment) {
  const commentElement = document.createElement('li');
  commentElement.className = 'comment';

  const titleElement = document.createElement('span');
  titleElement.innerText = comment.title;

  // Delete comment
  const deleteButtonElement = document.createElement('button');
  deleteButtonElement.classList.add("deleteButton");
  deleteButtonElement.classList.add("button01");
  
  deleteButtonElement.innerText = 'Delete';
  deleteButtonElement.addEventListener('click', () => {
    deleteComment(comment);

    // Remove the task from the DOM.
    commentElement.remove();
  });

  commentElement.appendChild(titleElement);
  commentElement.appendChild(deleteButtonElement);
  return commentElement;
}

/** Tells the server to delete the task. */
function deleteComment(comment) {
  const params = new URLSearchParams();
  params.append('id', comment.id);
  fetch('/delete-comment', {method: 'POST', body: params});
}

