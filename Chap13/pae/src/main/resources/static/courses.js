var requestData = new Vue({
    el: '#requestData',
    data: {
        listOfCourses: [],
    },
    created() {
        this.listCourses()
        console.log("the component is now mounted.");
    },
    methods: {
        listCourses: function () {
            url = "/api/coursesList";
            console.log("Appel Rest");
            axios.get(url)
                .then(function (response) {
                    this.coursesList = response.data;
                })
                .catch(function (error) {
                    alert("Erreur appel REST");
                });
        }
    },
});

var responseData = new Vue({
    el: '#responseData',
    data: {
        id: "",
        title: "",
        ECTS: 0
    }
});