
let variousDays = document.querySelector('#various-days');

variousDays.addEventListener('change', () => {
    // document.querySelector('#days-selection').removeAttribute('disabled');
    let selector = document.querySelector('#days-selection');
    selector.setAttribute("disabled", true);

    console.log(selector);
    // if (variousDays.checked) {
    // } else {
    // }
});
