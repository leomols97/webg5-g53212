var responseData = new Vue({
    el: '#responseData',
    data: {
        listOfCourses: ["MAT1", "Mathématiques 1", 8],
    },
    created() {
        this.listCourses();
        console.log("the component is now mounted.", this.listOfCourses );
    },
    methods: {
        listCourses: function () {
            url = "/api/coursesList";
            console.log("Appel Rest");
            axios.get(url)
                .then(function (response) {
                    this.listOfCourses = response.data;
                    console.log("the component is now mounted.", this.listOfCourses );
                })
                .catch(function (error) {
                    alert("Erreur appel REST");
                });
        }
    },
});

var requestData = new Vue({
    el: '#requestData',
    data: {
        id: "",
        title: "",
        ECTS: 0
    }
});