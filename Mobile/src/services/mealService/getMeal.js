import axios from 'axios';
const localhost = "localhost";  
export const fetchMealItems = async () => {
     const url = "http://"+localhost+":8080/meal/";
    console.log("Fetching data from:", url);
    try {
        const response = await axios.get(url);
        console.log("Data received:", response.data);
        // Returning the data received from the API
        return response.data;
    } catch (error) {
        // Handling errors if the request fails
        console.error("Error fetching data:", error);
        // Returning an empty array or another default value in case of error
        return [];
    }
};
