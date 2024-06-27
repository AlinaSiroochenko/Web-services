/**
 * Fetches restaurant data by name and displays it in a new window as HTML.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantByNameHTML() {
    event.preventDefault();
    const nameInput = document.getElementById('getRestaurantByNameInput');
    const name = nameInput.value;

    if (name.trim() === "") {
        alert("Please enter a restaurant name.");
        return false;
    }

    fetch('/restaurants/restaurant/name/html?name=' + encodeURIComponent(name))
        .then(response => response.text())
        .then(html => {
            const newWindow = window.open();
            newWindow.document.open();
            newWindow.document.write(html);
            newWindow.document.close();
        })
        .catch(error => {
            console.error('Error fetching restaurant by name as HTML:', error);
        });
}

/**
 * Fetches restaurant data by name and displays it in a new window as PDF.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantByNamePDF() {
    event.preventDefault();
    const nameInput = document.getElementById('getRestaurantByNameInput');
    const name = nameInput.value;

    if (name.trim() === "") {
        alert("Please enter a restaurant name.");
        return false;
    }

    fetch('/restaurants/restaurant/name/pdf?name=' + encodeURIComponent(name))
        .then(response => response.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const newWindow = window.open(url, '_blank');
            newWindow.focus();
        })
        .catch(error => {
            console.error('Error fetching restaurant by name as PDF:', error);
        });
}

/**
 * Fetches restaurant data by ID and displays it in a new window as HTML.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantByIdHTML() {
    event.preventDefault();
    const idInput = document.getElementById('getRestaurantByIdInput');
    const id = idInput.value;

    if (id.trim() === "") {
        alert("Please enter a restaurant ID.");
        return false;
    }

    fetch('/restaurants/restaurant/id/html?id=' + encodeURIComponent(id))
        .then(response => response.text())
        .then(html => {
            const newWindow = window.open();
            newWindow.document.open();
            newWindow.document.write(html);
            newWindow.document.close();
        })
        .catch(error => {
            console.error('Error fetching restaurant by ID as HTML:', error);
        });
}

/**
 * Fetches restaurant data by ID and displays it in a new window as PDF.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantByIdPDF() {
    event.preventDefault();
    const idInput = document.getElementById('getRestaurantByIdInput');
    const id = idInput.value;

    if (id.trim() === "") {
        alert("Please enter a restaurant ID.");
        return false;
    }

    fetch('/restaurants/restaurant/id/pdf?id=' + encodeURIComponent(id))
        .then(response => response.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const newWindow = window.open(url, '_blank');
            newWindow.focus();
        })
        .catch(error => {
            console.error('Error fetching restaurant by ID as PDF:', error);
        });
}

/**
 * Fetches all restaurants data and displays it in a new window as HTML.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantsHTML() {
    event.preventDefault();

    fetch('/restaurants/html')
        .then(response => response.text())
        .then(html => {
            const newWindow = window.open();
            newWindow.document.open();
            newWindow.document.write(html);
            newWindow.document.close();
        })
        .catch(error => {
            console.error('Error fetching restaurants as HTML:', error);
        });
}

/**
 * Fetches all restaurants data and displays it in a new window as PDF.
 * @returns {boolean} Returns false to prevent default form submission.
 */
function searchRestaurantsPDF() {
    event.preventDefault();

    fetch('/restaurants/pdf')
        .then(response => response.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const newWindow = window.open(url, '_blank');
            newWindow.focus();
        })
        .catch(error => {
            console.error('Error fetching restaurants as PDF:', error);
        });
}

/**
 * Selects all text in the input field when it receives focus.
 * @param {Event} event - The focus event.
 */
const onFocusSelect = function(event) {
    this.select();
};

document.getElementById('getRestaurantByNameInput').addEventListener('focus', onFocusSelect);
document.getElementById('getRestaurantByIdInput').addEventListener('focus', onFocusSelect);
