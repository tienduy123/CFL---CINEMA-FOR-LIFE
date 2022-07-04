Vue.component('movie-name', {
      props : ['m_name'],
      template : `
            <h3 class="movie-name-bg"
            style="color: #ff3838; text-shadow: 0px 1.5px black;"> {{m_name}} </h3>
      `
})
Vue.component('footer-list', {
      props : ['list'],
      template : '<li style="color: white;">{{ list }}</li>'
})
Vue.component('chair-stock', {
      props : ['chair'],
      template : '<button>{{chair}}</button>'
})
const app = new Vue(
      {
            el : '#app',
            data : {
                  m_names : [
                        {
                              id : 1, m_name : "Avenger: Infinity War"
                        },
                        {
                              id : 2, m_name : "Avenger: ENDGAME"
                        },
                        {
                              id : 3, m_name : "Doctor Strange"
                        },
                        {
                              id : 4, m_name : "Spider-Man: Homecoming"
                        },
                        {
                              id : 5, m_name : "Spider-Man: Far From Home"
                        },
                  ],
                  list_contacts : [
                        {
                              id : 1, list : "Phone Number : 0123456789"
                        },
                        {
                              id : 2, list : "Telephone Number : 2134545354"
                        },
                        {
                              id : 3, list : "-----------------"
                        },
                  ],
                  list_addresses : [
                        {
                              id : 1, list : "1/17 PASTEUR, QUAN 1, TP HCM"
                        },
                        {
                              id : 2, list : "-----------------------------"
                        },
                        {
                              id : 3, list : "-----------------------------"
                        }
                  ],
                  list_fanpages : [
                        {
                              id : 1, list : "Facebook"
                        },
                        {
                              id : 2, list : "Youtube"
                        },
                        {
                              id : 3, list : "---------------"
                        }
                  ]
            }
      }
)

let count = 1;
let titles = {
      $title1 : "Avenger: ENDGAME",
      $title2 : "Doctor Strange",
      $title3 : "Fate/Stay Night: Unlimited Blade Works",
      $title4 : "Kimetsu no Yaiba: Mugen Ressha-hen"
};
setInterval(function() {
      document.getElementById('rdo' + count).checked = true;
      count++;
      if(count > 4)
      {
            count = 1;
      }
      let active = document.getElementById('rdo' + count).checked = true;
      if(active) {
            document.getElementById('rdop' + count).checked = true;
            let index = document.getElementById('movie-title');
            index.innerHTML = (count == 1) ? titles.$title1 : 
            (count == 2) ? titles.$title2 : 
            (count == 3) ? titles.$title3 : 
            (count == 4) ? titles.$title4 : count=1;
      }
}, 5000);