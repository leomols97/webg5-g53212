var requestData = new Vue({
    el: '#requestData',
    data: {
        listOfStudents: [],
        studentModel: "",
        matricule: 0,
        name: "",
        gender: '',
        section: '',
    },
    mounted() {
        this.listStudents();
        console.log("the component is now mounted.");
    },
    methods: {
        listStudents: function () {
            url = "/api/studentsList";
            console.log("Appel Rest STUDENTS");
            axios.get(url)
                .then(function (request) {
                    requestData.listOfStudents = request.data;
                    console.log("students", request.data);
                })
                .catch(function (error) {
                    console.log(error);
                    alert("Erreur appel rest STUDENTS");
                });
        },
        showStudent: function () {
            console.log(this.studentModel);
            responseData.student = this.studentModel;
        },
    },
});

var responseData = new Vue({
    el: '#responseData',
    data: {
        student: {},
    }
});