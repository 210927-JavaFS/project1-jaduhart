const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let pastReimButton = document.getElementById("pastReimButton");
let addReimButton = document.getElementById('addReimButton');
let loginButton = document.getElementById('loginButton');
let getReimButton = document.createElement('getReim');
let showReimButton = document.getElementById('showReimButton');
let getUsersButton = document.getElementById('showUsersButton');
let getStatIdButton = document.getElementById('filterStatusButton');

//let authString = 0;

const STATUSPENDING = {"reimb_Status_Id": "1",'reimb_Stat':'PENDING'};
const STATUSAPPROVED = {"reimb_Status_Id": "2",'reimb_Stat':'APPROVED'};
const STATUSDENIED = {"reimb_Status_Id": "3",'reimb_Stat':'DENIED'} ;

const TYPELODGING = {"reimb_Type_Id": "1",'reimb_Type':'LODGING'};
const TYPETRAVEL = {"reimb_Type_Id": "2",'reimb_Type':'TRAVEL'};
const TYPEFOOD = {"reimb_Type_Id": "3",'reimb_Type':'FOOD'} ;
const TYPEOTHER = {"reimb_Type_Id": "4",'reimb_Type':'OTHER'};


pastReimButton.onclick = getReims;
showReimButton.onclick = getReims;
addReimButton.onclick = addReim;//was addReim
loginButton.onclick = loginToApp; 
getReimButton.innerText = "get Reimbursements";
getUsersButton.onclick = getUsers;
getStatIdButton.onclick = getReimsbyStat;



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
  console.log(response);
  let curUser = await response.json();  
  console.log(curUser);
  console.log(curUser.user_Role.user_Role_Id)
  //&& Object(curUser).User_Role == 1
  if(response.status===200 && curUser.user_Role.user_Role_Id  == 1 ){
    
    document.getElementsByClassName("formClass")[0].innerHTML = '';
    
    buttonRow.appendChild(getReimButton);
   // buttonRow.appendChild(reimButton);
  }
  
  else if(response.status===200 && curUser.user_Role.user_Role_Id == 2){
    document.getElementsByClassName("formClass")[0].innerHTML = '';
    buttonRow.appendChild(getReimButton);
   // buttonRow.appendChild(reimButton);
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
    console.log(data)
    populateReimTable(data);
  }else{
    console.log("ResponseStat !=200, populateReimTable never called");
  }
};

function populateReimTable(data){
  let tbody = document.getElementById("reimBody");

  tbody.innerHTML="";

  let reimArray = data;
  console.log(data);
 // for(let j=0; j< reimArray.length; j++ ){
    // let row = document.createElement("tr");

      for (let user of data) {
        let row = document.createElement("tr");
        row.style.width = '100%';
        // for (let cell in user) {
        let td = document.createElement("td");
        td.innerText = `${user.reimb_Id}`; 
        row.appendChild(td);
        let td1 = document.createElement("td");
        td1.innerText = `${user.reimb_Amt}`; 
        row.appendChild(td1);
        let td2 = document.createElement("td");
        td2.innerText = ` ${convertTimestamp(user.reimb_Sub)}`; 
        row.appendChild(td2);
        let td3 = document.createElement("td");
        td3.innerText = ` ${convertTimestamp(user.reimb_Resd)}`; 
        row.appendChild(td3);
        let td4 = document.createElement("td");
        td4.innerText = ` ${user.reimb_Auth.first_Name}`; 
        row.appendChild(td4);
        let td5 = document.createElement("td");
        td5.innerText = ` ${user.reimb_Res.first_Name}`; 
        row.appendChild(td5);
        let td6 = document.createElement("td");
        td6.innerText = `  ${user.reimb_TypeId.reimb_Type}`; 
        row.appendChild(td6);
        let td7 = document.createElement("td");
        td7.innerText = `  ${user.reimb_StatId.reimb_Stat}`; 
        row.appendChild(td7);
        
            // if (user[cell]=='reimb_Auth') {
            //   td.innerText = `${user[cell].username}`;

            // } 
            // else if (user[cell]=='reimb_Res') {
            //     if (cell = null){
            //           td.innerText = 'null';
            //       }
            //     else{
            //       td.innerText = `${user[cell].username}`;
            //     }

            // }
            // else if (user[cell]== ' reimb_StatId'){
            //   td.innerText = `${user[cell].reimb_Stat}`;
            // }
            // else if (user[cell]== ' reimb_TypeId'){
            //   td.innerText = `${user[cell].reimb_Type}`;
            // }
            // else if (user[cell]){
            //   td.innerText = `${user[cell]}`;
            // }
            // row.appendChild(td);
            tbody.appendChild(row);
          }
      
  }
  // async function getAllByUser(){
  //   let id = document.getElementById("userId").value;
  //   let response = await fetch(URL+"reimbs/user/"+id);
  //   if(response.status===200){
  //     let data = await response.json();
  //   toArray(data);
  //   }else{
  //     console.log("Reimbs not available. "+response);
  //   }
  // }
  
  async function getReimsbyStat(){
    let id = document.getElementById('statId').value;
    let response = await fetch(URL+"Ers_Reimbursement/Open/"+ id );
  
    if(response.status === 200){
      let data = await response.json();
      console.log(data)
      populateReimTable(data);
    }else{
      console.log("ResponseStat !=200, populateReimTable never called");
    }
  };
    //else if(cell=="receipt"&&Ers_Reimbursement[cell]){//if null: false. else true.
    //     td.innerText = `${Ers_Reimbursement[cell]}  `
    // }else if(Ers_Reimbursement[cell]){
    //     td.innerText = `${Ers_Reimbursement[cell]}  `
    // }
    //  else if(Ers_Reimbursement[cell]){
    //     td.innerText = `${Ers_Reimbursement[cell].Reimb_Amt}: 
    //       ${Ers_Reimbursement[cell].Reimb_StatId} ${Ers_Reimbursement[cell].Reimb_TypeId}`
    //   }
    //   row.appendChild(ReimObj);
    // }
   
  // tbody.appendChild(ReimObj);
  // }

function convertTimestamp(unix_timestamp){
  var date = new Date(unix_timestamp);

  return date;
}

function financeManagerPage(){

}
function financeEmployeePage(){

}

async function getUsers(){
  let response = await fetch(URL+"users");
  if(response.status===200){
    let data = await response.json();
    populateUserTable(data);
    console.log(data);
  }else{
    console.log("Users not available.");
  }
}

function populateUserTable(data){
  let tbody = document.getElementById("userBody");

  tbody.innerHTML="";

  for(let home of data){
    let row = document.createElement("tr");
    for(let cell in home){
      let td = document.createElement("td");
     
      // if(cell!="user"){
      //   td.innerText=home[cell];
      // }
      // else if((cell=="submitted"||cell=="resolved")&&home[cell]){//if null: false. else true.
             
      //   td.innerText = ` ${home[cell].User_Id} 
      //   ${home[cell].Username}${home[cell].First_Name}${home[cell].Last_Name} ${home[cell].Email} ${home[cell].User_Role} `
      // } 
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

  function getNewReim(){
    let newAmount = document.getElementById("reimAmount").value;
    let newDescription = document.getElementById("reimDescription").value; 
    let newType = document.getElementById("reimType").value;
      switch( newType.toUpperCase()) {
          case 'LODGING':
              newReimbType = TYPELODGING;
              break;
          case 'FOOD':
              newReimbType = TYPEFOOD;
              break;
          case 'TRAVEL':
              newReimbType = TYPETRAVEL;
              break;
          case 'OTHER':
            newReimbType = TYPEOTHER;
              break;
      }

    let reimbursement =  {
    reimb_Amt: newAmount,
    reimb_Sub: new Date().toISOString(),
    reimb_Des: newDescription,
    reimb_Auth: null,
    reimb_Res: null,
    reimb_StatId: STATUSPENDING,
    reimb_TypeId: newReimbType
    }
  
  return reimbursement;

}


async function addReim(){
  let  reimbursement = getNewReim();
  console.log(reimbursement);

  let response = await fetch(URL+"Ers_Reimbursement", {
    method:'POST',
    body:JSON.stringify(reimbursement)
  });

  if(response.status===201){
    console.log("reim created successfully.");
  }else{
    console.log("Something went wrong creating your reim.")
  }
}