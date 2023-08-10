const getUserInfo = "http://localhost:8080/users";



document.getElementById('userForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData(form);
    const user = {
      email: formData.get('email'),
      username: formData.get('username'),
      password: formData.get('password')
    };

    try {
      const response = await fetch(getUserInfo, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
      });

      if (response.ok) {
        console.log('User created successfully');
        // Perform any further actions or redirect to another page
      } else {
        console.error('Failed to create user');
      }
    } catch (error) {
      console.error('An error occurred:', error);
    }
  });


  const getUser = async () => {
    try{
        const response = await fetch(getUserInfo); 
        if(response.ok){
            const data = await response.json(); 
            console.log(data); 
        }else{
            throw new Error("Unable to get users")
        }
    }catch(error){
        console.log("Error " + error)
    }
    
  }

getUser(); 

