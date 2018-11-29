var BackEndModule =(function(){

    return{
        StockExchange: async function(callback){

            await Promise.resolve(axios.get('/StockExchange/'+document.getElementById('func').value+'/'+document.getElementById('symbol').value))
                .then(async function(response){
                        console.log(response.data);

                    document.getElementById("data").innerHTML = "";
                    document.getElementById("data").innerHTML = JSON.stringify(response.data);

                    }
                )}
    };


})();