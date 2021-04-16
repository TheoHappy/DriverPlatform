const requestURL = 'http://localhost:8085/drivers'

function sendRequest(method, url) {
    return fetch(url)
}

sendRequest('GET',requestURL)
    .then(data => console.log(data))
    .catch(err => console.log(err))

