
const element = document.getElementById("stars");
const star = "★"; 
const whiteStar = "☆"; 
const maxRows = 5;
const maxCols = 5; 

for (let i = 0; i < 5; i++) {
  element.insertAdjacentHTML("afterbegin", star);
}

const starContainer = document.getElementById("stars");

starContainer.insertAdjacentHTML("beforeend", "<br>");
starContainer.insertAdjacentHTML("beforeend", "<br>");


for (let row = 0; row < maxRows; row++) {
  for (let col = 0; col < maxCols; col++) {
    const currentStar = ((row + col) % 2 === 0) ? whiteStar : star;
    starContainer.insertAdjacentHTML("beforeend", currentStar);
  }
  starContainer.insertAdjacentHTML("beforeend", "<br>");
}

starContainer.insertAdjacentHTML("beforeend", "<br>");


const products = {
  coffee: 150,
  tea: 130,
  orange: 160,
  water: 100
};


document.getElementById("buyButton").addEventListener("click", () => {
  const amount = parseInt(document.getElementById("amount").value, 10); 
  const selectedProduct = document.getElementById("product").value; 
  const productPrice = products[selectedProduct]; 

  const resultElement = document.getElementById("result"); 

  if (amount >= productPrice) {
    const change = amount - productPrice;
    resultElement.textContent = `「${selectedProduct}」を購入しました！ お釣りは ${change} 円です。`;
  } else {
    resultElement.textContent = "お金が足りません。";
  }
});