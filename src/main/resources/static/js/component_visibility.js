document.body.addEventListener("click", function(event) {
    let menu = document.getElementById("contentMenu");
    let button = document.getElementById("showMenu");

    if (menu && !menu.contains(event.target) && event.target !== button) {
        menu.style.display = "none";
    }
});

document.getElementById("showMenu").addEventListener("click", function(event) {
    let menu = document.getElementById("contentMenu");
    if (menu) {
        menu.style.display = (menu.style.display === "none" || menu.style.display === "") ? "block" : "none";
        event.stopPropagation();
    }
});