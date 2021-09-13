package com.example.myquizapp

object Contants {
    const val USER: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<questions>{
        val questionList = ArrayList<questions>()
        val ques1 = questions(
            1,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Brazil",
            "Fiji",
            1
        )
        questionList.add(ques1)
        val ques2 = questions(
            2,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_australia,
            "India",
            "Australia",
            "China",
            "USA",
            2
        )
        questionList.add(ques2)
        val ques3 = questions(
            3,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_belgium,
            "Germany",
            "India",
            "Brazil",
            "Belgium",
            4
        )
        questionList.add(ques3)
        val ques4 = questions(
            4,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_brazil,
            "India",
            "Australia",
            "Brazil",
            "Fiji",
            3
        )
        questionList.add(ques4)
        val ques5 = questions(
            5,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_denmark,
            "Russia",
            "Australia",
            "Fiji",
            "Denmark",
            4
        )
        questionList.add(ques5)
        val ques6 = questions(
            6,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Australia",
            "Brazil",
            "Fiji",
            4
        )
        questionList.add(ques6)
        val ques7 = questions(
            7,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "India",
            "Denmark",
            "Argentina",
            1
        )
        questionList.add(ques7)
        val ques8 = questions(
            8,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_india,
            "Brazil",
            "India",
            "Belgium",
            "New Zealand",
            2
        )
        questionList.add(ques8)
        val ques9 = questions(
            9,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "Kuwait",
            "Fiji",
            "China",
            2
        )
        questionList.add(ques9)
        val ques10 = questions(
            10,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,
            "India",
            "Brazil",
            "New Zealand",
            "Russia",
            3
        )
        questionList.add(ques10)
        return questionList
    }
}