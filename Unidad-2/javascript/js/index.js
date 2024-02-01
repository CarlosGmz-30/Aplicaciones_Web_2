const suma = 3 + '0.5';
const resta = 3 - '0.5';
// console.log(suma);
// console.log(resta);

const person = {
    name: "Carlos",
    lastname: "Martínez",
    age: 20,
};

// DESESTRUCTURACIÓN 
const { name, age } = person;

// console.log(name, age);

const people = [
    {
        name: "Carlos",
        lastname: "Martínez",
        age: 20,
    },
    {
        name: "Keyla",
        lastname: "Hurtado",
        age: 22,
    },
];


const [person2, person3] = people;
// console.log(person2);
// console.log(person3);

// PROMESAS

// ArrowFunction - function - Function
const getData = async () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            reject({
                data: '',
                error: false,
                message: 'OK'
            });
        }, 2000);
    });
};

let response = undefined;
const resolveData = async () => {
    try {
        const response = await getData();
        console.log(response);
    } catch (error) {
        console.log(error);
    }
};
resolveData();

/*
getData()
    .then((response) => {
        response = response;
        console.log(response);
    })
    .catch(console.error);
console.log(response);
*/