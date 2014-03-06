setTimeout(timeoutRecurse, 1000);    

var timeoutRecurse = function() {
    console.log('hi');
    setTimeout(timeoutRecurse, 1000);
};

