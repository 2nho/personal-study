const items = document.querySelectorAll("article");

for (const item of items) {
    item.addEventListener("mouseenter", function(){
        this.querySelector("video").play();
    });

    item.addEventListener("mouseleave", function(){
        this.querySelector("video").pause();
    });
}