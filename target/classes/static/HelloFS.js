const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let pastReimButton = document.getElementById("pastReimButton");
let addReimButton = document.getElementById('addReimButton');
let loginButton = document.getElementById('loginButton');
let curUser = null

pastReimButton.onclick = getReims;
// reimButton.onclick = getreims;
addReimButton.onclick = getReims;//was addReim
loginButton.onclick = loginToApp; 

// avengerButton.innerText = "Avengers Assemble";
// reimButton.innerText = "See reims";
async function loginToApp(){
  sessionStorage.clear();
  let user = {
    username:document.getElementById("username").value,
    password:document.getElementById("password").value
  }

  let response = await fetch(URL+"login", {
    method:"POST",
    body:JSON.stringify(user),
    credentials:"include" //This will save the cookie when we receive it. 
  });

  if(response.status===200){
    document.getElementsByClassName("formClass")[0].innerHTML = '';
    buttonRow.appendChild(avengerButton);
    buttonRow.appendChild(reimButton);
  }
  else{
    let para = document.createElement("p");
    para.setAttribute("style", "color:red")
    para.innerText = "LOGIN FAILED"
    document.getElementsByClassName("formClass")[0].appendChild(para);
  }
}



async function getReims(){
  let response = await fetch(URL+"Ers_Reimbursement");

  if(response.status === 200){
    let data = await response.json();
    populateReimTable(data);
  }else{
    console.log("The Avengers are too busy saving the planet to respond.");
  }
};

function populateReimTable(data){
  let tbody = document.getElementById("reimBody");

  tbody.innerHTML="";

  for(let Ers_Reimbursement of data){
    let row = document.createElement("tr");


    myArray = Object.values(data);
    for(let cell in Ers_Reimbursement){
      let td = document.createElement("td");
      
      if(cell!="Ers_Reimbursement"){
        td.innerText=Ers_Reimbursement[cell];
      }
      else if((cell=="submitted"||cell=="resolved")&&Ers_Reimbursement[cell]){//if null: false. else true.
             
        td.innerText = `${convertTimestamp(Ers_Reimbursement[cell])} ${Ers_Reimbursement[cell].Reimb_Amt}: 
        ${Ers_Reimbursement[cell].Reimb_StatId} ${Ers_Reimbursement[cell].Reimb_TypeId} `
      }
    //else if(cell=="receipt"&&Ers_Reimbursement[cell]){//if null: false. else true.
    //     td.innerText = `${Ers_Reimbursement[cell]}  `
    // }else if(Ers_Reimbursement[cell]){
    //     td.innerText = `${Ers_Reimbursement[cell]}  `
    // }
    //  else if(Ers_Reimbursement[cell]){
    //     td.innerText = `${Ers_Reimbursement[cell].Reimb_Amt}: 
    //       ${Ers_Reimbursement[cell].Reimb_StatId} ${Ers_Reimbursement[cell].Reimb_TypeId}`
    //   }
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}

function convertTimestamp(unix_timestamp){
  var date = new Date(unix_timestamp);

  return date;
}

async function get(){
  let response = await fetch(URL+"Ers_Reimbursements");
  if(response.status===200){
    let data = await response.json();
    populateReimTable(data);
  }else{
    console.log("Reimbursements not available.");
  }
}

function populateUserTable(data){
  let tbody = document.getElementById("userBody");

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

// function getNewHome(){
//   let newName = document.getElementById("homeName").value;
//   let newStreetNum = document.getElementById("homeStreetNum").value; 
//   let newStreetName = document.getElementById("homeStreetName").value;
//   let newCity = document.getElementById("homeCity").value;
//   let newRegion = document.getElementById("homeRegion").value;
//   let newZip = document.getElementById("homeZip").value;
//   let newCounty = document.getElementById("homeCountry").value;

//   function getNewReim(){
//     let newAmount = document.getElementById("reimbursementAmount").value;
//     let newDescription = document.getElementById("description").value; 
//     let newTypeID = document.getElementById("typeID").value;

//     let reimbursement =  {
//     amount: newAmount,
//     submitted: new Date().toISOString(),
//     description: newDescription,
//     author: curUser,
//     statusID: 1,
//     typeID: newTypeID
//     }

//     return reimbursement;
// }

  // let home =  {
  //   name:newName,
  //   streetNumber:newStreetNum,
  //   streetName:newStreetName,
  //   city:newCity,
  //   region:newRegion,
  //   zip:newZip,
  //   country:newCounty
  // }

//   return home;
// }

// async function addReim(){
//   let  = getNewreim();

//   let response = await fetch(URL+"reims", {
//     method:'POST',
//     body:JSON.stringify(reim)
//   });

//   if(response.status===201){
//     console.log("reim created successfully.");
//   }else{
// //     console.log("Something went wrong creating your reim.")
// //   }

// 