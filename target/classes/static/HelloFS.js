const URL = "http://localhost:8081/";

let avengerButton = document.getElementById('avengerButton');
let homeButton = document.getElementById('homeButton');
let addHomeButton = document.getElementById('addHomeButton');

avengerButton.onclick = getAvengers;
homeButton.onclick = getHomes;
addHomeButton.onclick = addHome;

async function getAvengers(){
  let response = await fetch(URL+"avengers");

  if(response.status === 200){
    let data = await response.json();
    populateAvengersTable(data);
  }else{
    console.log("The Avengers are too busy saving the planet to respond.");
  }
};

function populateAvengersTable(data){
  let tbody = document.getElementById("avengerBody");

  tbody.innerHTML="";

  for(let avenger of data){
    let row = document.createElement("tr");

    for(let cell in avenger){
      let td = document.createElement("td");
      if(cell!="home"){
        td.innerText=avenger[cell];
      }else if(avenger[cell]){
        td.innerText = `${avenger[cell].name}: ${avenger[cell].streetNumber} ${avenger[cell].streetName} ${avenger[cell].city } ${avenger[cell].region}, ${avenger[cell].zip} ${avenger[cell].country}`
      }
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}

async function getHomes(){
  let response = await fetch(URL+"homes");
  if(response.status===200){
    let data = await response.json();
    populateHomeTable(data);
  }else{
    console.log("Homes not available.");
  }
}

function populateHomeTable(data){
  let tbody = document.getElementById("homeBody");

  tbody.innerHTML="";

  for(let home of data){
    let row = document.createElement("tr");
    for(let cell in home){
      let td = document.createElement("td");
      td.innerText = home[cell];
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}

function getNewHome(){
  let newName = document.getElementById("homeName").value;
  let newStreetNum = document.getElementById("homeStreetNum").value; 
  let newStreetName = document.getElementById("homeStreetName").value;
  let newCity = document.getElementById("homeCity").value;
  let newRegion = document.getElementById("homeRegion").value;
  let newZip = document.getElementById("homeZip").value;
  let newCounty = document.getElementById("homeCountry").value;

  let home =  {
    name:newName,
    streetNumber:newStreetNum,
    streetName:newStreetName,
    city:newCity,
    region:newRegion,
    zip:newZip,
    country:newCounty
  }

  return home;
}

async function addHome(){
  let home = getNewHome();

  let response = await fetch(URL+"homes", {
    method:'POST',
    body:JSON.stringify(home)
  });

  if(response.status===201){
    console.log("Home created successfully.");
  }else{
    console.log("Something went wrong creating your home.")
  }

}