/*
 * switchOutFeedback takes an item id and an array of current feedback, 
 * hides all the feedback for that item, and then displays the current
 * feedback and the general feedback.  
 */
function switchOutFeedback(item_id, todisplay)
{
    // First, hide all feedback.
    // Get all div tags, search through for div tags that have 'feedbaq' in their id, and hide them.
    var thedivs = document.getElementById(item_id).getElementsByTagName('div');
    var divcount = 0;
    while (divcount < thedivs.length)
        {
            var afeedback = /^feedbaq/;
            var thefeedback = afeedback.test(thedivs[divcount].id);
            if (thefeedback == true)
                    {
                    thedivs[divcount].style.display = 'none';
                }
            divcount++;
        }

    //Next, show each feedback in todisplay.
    var feedbackcount = 0;
    while (feedbackcount < todisplay.length)
        {
            showDivision('feedbaq_' + todisplay[feedbackcount], item_id);
            feedbackcount++;
        }
}


/*
 * showAnswer takes an item id, 'answers' (a string for single-response; a form for 
 * multiple- and ordered-response; and a string for text-response), and a key.  It gets 
 * the item type from the item id by string matching and calls the correct 
 * answer-processing function for that item-type.
 * 
 */
function showAnswer(item_id, answers, thekey)
{
    // the type of item is stored as part of the form id for that item.
    var theitem = document.getElementById(item_id).getElementsByTagName('form');
    var itemtype = theitem[0].id;
 
    // Match against regular expressions, pass to correct function.
    var single = /^single/;
    var multiple = /^multiple/;
    var ordered = /^ordered/;
    var text = /^text/;
    
    if (single.test(itemtype))   showAnswerSingle(item_id, answers, thekey);
    if (multiple.test(itemtype)) showAnswerMultiple(item_id, answers, thekey);
    if (ordered.test(itemtype))  showAnswerOrdered(item_id, answers, thekey);
    if (text.test(itemtype))     showAnswerText(item_id, answers, thekey);
}

/*
 * showAnswerSingle first checks to see if thekey is no-key-present.  If it is not,
 * it checks the answerstring against the key, calls showCorrectOrIncorrect depending
 * on the result, turns the string into an array and calls switchOutFeedback on it, 
 * and shows the general feedback.  If the key is no-key-present, it just turns the 
 * string into an array, calls switchOutFeedback on it, and shows the general feedback.
 */
function showAnswerSingle(item_id, answerstring, thekey)
{
    // If there is a key:
    if (thekey != 'no-key-present')
        {
            // Answer processing.
            if ( thekey == answerstring ) showCorrectOrIncorrect(item_id, 'correct');
            else                          showCorrectOrIncorrect(item_id, 'incorrect');
        }
    // Turn the answer into an array to pass to switchOutFeedback.  Show general feedback.
    answerarray = new Array(answerstring);
    showDivision('general', item_id);
    switchOutFeedback(item_id, answerarray);

}

/*
 * showAnswerMultiple calls getCheckedMultipleAndOrdered to get an array of the
 * responses that have been checked, and sorts that array.  If there were
 * checked responses i.e. the user supplied an answer, and there is a key present,
 * it splits the key into an array, sorts that array, calls 
 * checkKeyMultipleAndOrdered to compare the key and responses, and calls 
 * showCorrectOrIncorrect depending on the results.  It then switches
 * out the feedback, shows the general feedback, and resets the array of responses
 * for the next time around.  
 *
 * If the key is not present, but the user has supplied a response, it shows the
 * response-specific and general feedback, and resets the array of responses.
 *  
 * If user has not supplied a response, and there _is_ a key present, the response
 * is scored as incorrect.
 */
function showAnswerMultiple(item_id, answerform, thekey)
{
    var checkedmultiplechoice;
    var key;
    var bSuccess;

    // Get an array of checked responses, sort it for comparison
    // against the key.
    checkedmultiplechoice = getCheckedMultipleAndOrdered(gOrderedAnswerSets, item_id);
    checkedmultiplechoice.sort();
    if ( checkedmultiplechoice.length > 0 )
    {
        if ( thekey != 'no-key-present' )
        {
            // If there is a response and a key:
            key = thekey.split(",");
            key.sort();

            // Check to see whether key and answers match up.
            bSuccess = checkKeyMultipleAndOrdered(checkedmultiplechoice, key);
            if ( bSuccess ) showCorrectOrIncorrect(item_id, 'correct');
            else            showCorrectOrIncorrect(item_id, 'incorrect');
        }

        switchOutFeedback(item_id, checkedmultiplechoice);
    }

    // If there is a key, but there is no response, show incorrect.  
    if ( (checkedmultiplechoice.length == 0 ) && (thekey !='no-key-present') )
    {
        showCorrectOrIncorrect(item_id, 'incorrect');
    }

    showDivision('general', item_id);
}

/*
 * showAnswerOrdered calls getCheckedMultipleAndOrdered to get an array of the
 * responses that have been checked.  If there were checked responses i.e. 
 * the user supplied an answer, and there is a key present, it splits the key 
 * into an array and calls checkKeyMultipleAndOrdered to compare the key and 
 * responses, and calls showCorrectOrIncorrect depending on the results.  It then switches
 * out the feedback, and shows the general feedback.
 *
 * If the key is not present, but the user has supplied a response, it shows the
 * response-specific and general feedback, and resets the array of responses.
 *  
 * If user has not supplied a response, and there _is_ a key present, the response
 * is scored as incorrect.
 */
function showAnswerOrdered(item_id, whatever, thekey)
{
    var vOrderedUserAnswers;
    var key;
    var bSuccess;

    vOrderedUserAnswers = getCheckedMultipleAndOrdered(gOrderedAnswerSets, item_id);

    if ( vOrderedUserAnswers.length > 0 )
    {
        if (thekey != 'no-key-present')
        {
            // If there is an answer and a key:
            key = thekey.split(",");

            // Check to see whether key and answers match up.
            bSuccess = checkKeyMultipleAndOrdered(vOrderedUserAnswers, key);
            if ( bSuccess ) showCorrectOrIncorrect(item_id, 'correct');
            else            showCorrectOrIncorrect(item_id, 'incorrect');
        }
        switchOutFeedback(item_id, vOrderedUserAnswers);
    }

    // If there is a key, but there is no response, show incorrect.  
    if ( (vOrderedUserAnswers.length == 0) && (thekey !='no-key-present') )
    {
        showCorrectOrIncorrect(item_id, 'incorrect');
    }

    showDivision('general', item_id);
}

/*
 * getCheckedMultipleAndOrdered takes an array of arrays, an item id, and
 * finds the subarray whose first element matches the item id.
 * If there is no such subarray, it returns a new array.
 * It there is a matching subarray, it lops off the first two elements
 * and returns that subarray.
 */
function getCheckedMultipleAndOrdered(answers_array, item_id)
{
    if ( answers_array[item_id] != null ) {
        var vUserAnswerSet;
        vUserAnswerSet = answers_array[item_id];
        // do we remove this from gOrderedAnswerSets
        return vUserAnswerSet;
    } else {
        return new Array();
    }
}


gOrderedAnswerSets = new Array();


/*
 * addMe takes an item id and an element.  If that element is not checked,
 * it does nothing; if it is checked, it searches through the subarrays of 
 * gOrderedAnswerSets for the subarray whose first element matches the
 * item id.  If there is no such subarray, it makes a new one, sets the 
 * first element equal to item_id, and sets the second element to 2, the
 * next available value in the array.  If there is such a subarray, it
 * gets the second element of that array, which is equal to the next undefined 
 * element in the array, and sets that undefined element equal to the element's
 * value.
 * 
 */

function addMe(item_id, element)
{
    var i;
    var bFound;

    if ( element.checked ) {
        if ( gOrderedAnswerSets[item_id] == null ) {
            gOrderedAnswerSets[item_id] = new Array();
            gOrderedAnswerSets[item_id].push(element.value);
        } else {
            // don't add twice
            bFound = false;
            for (i=0; i<gOrderedAnswerSets[item_id].length; i++) {
                if ( gOrderedAnswerSets[item_id][i] == element.value ) {
                    bFound = true;
                    break;
                }
            }
            if ( ! bFound ) {
                gOrderedAnswerSets[item_id].push(element.value);
            }
        }
    } else {
        if ( gOrderedAnswerSets[item_id] != null ) {
            bFound = false;
            for (i=0; i<gOrderedAnswerSets[item_id].length; i++) {
                if ( gOrderedAnswerSets[item_id][i] == element.value ) {
                    bFound = true;
                    break;
                }
            }
            if ( bFound ) {
                // gOrderedAnswerSets[item_id][i] has got to go ...
                gOrderedAnswerSets[item_id].splice(i, 1);
            }
        }
    }
}



/*
 * showAnswerText only shows the general feedback at this time.  (Add math 
 * processing at some point?)
 */
function showAnswerText(item_id, answerstring)
{
    showDivision('general', item_id);
}


/*
 * Takes an array of answers and an array of keys and checks 
 * them against each other.  If they're not the same length, 
 * or if any item in one doesn't match the corresponding item
 * in the other, returns false.  If the arrays match completely,
 * returns true.
 *
 * This function is called by showAnswerMultiple and showAnswerOrdered.
 *
 */
function checkKeyMultipleAndOrdered(vUserAnswers, vKeyAnswers)
{
    var i;

    if (vUserAnswers.length != vKeyAnswers.length)
    {
        // If they're not the same length, the answer is wrong.
        return false;
    }
    else
    {
        // If they are the same length, loop through and check to 
        // see that they match up exactly.

        for (i=0; i<vKeyAnswers.length; i++)
        {
            // If they don't match:
            if (vUserAnswers[i] != vKeyAnswers[i])
            {
                return false;
            }
        }

        // If you've looped through, and found no wrong answers:
        return true;
    }
}


/*
 * showDivision takes an item id and a division name (not including the item id) and 
 * reveals the division with that id within the corresponding item.
 */
function showDivision(divname, item_id)
{
    var thediv = document.getElementById(divname + "_" + item_id);
    if (thediv != undefined) thediv.style.display = 'block';
}

/*
 * showDivision takes an item id and a division name (not including the item id) and 
 * hides the division with that id within the corresponding item.
 */
function hideDivision(divname, item_id)
{
   var thediv = document.getElementById(divname + "_" + item_id);
    if (thediv != undefined) thediv.style.display = 'none';
}


/*
 * Takes an item id and a condition (correct or incorrect) and 
 * hides the answer 'correct' and shows 'incorrect' and vice versa.
 */
function showCorrectOrIncorrect(item_id, cond)
{ 
    
    if (cond == 'correct')
        {
            showDivision('correct', item_id);
            hideDivision('incorrect', item_id);
        }
    if (cond == 'incorrect')
        {
            showDivision('incorrect', item_id);
            hideDivision('correct', item_id);
        }
} 



/* 
 * onLoad, constructHintCounter constructs an array of subarrays.
 * Each subarray contains id (the id of an item) and hintnum 
 * (the hint that should be displayed next for that item, originally
 * set to 0).
 */
var hintcounter = new Array();

function constructHintCounter()
{
var v = navigator.appVersion.toUpperCase();
var version = v.substring(0, 1);

// XXX FIX ME -- Use better browser detection!!! XXX
if (version >= 5)
{
    // Get all the divs, then build an array of only those
    // that are actually items.
    var divs = document.getElementsByTagName('div');
    var items = new Array();
    var itemcounter = 0;
    var itemtest = /qmlitem/;
    if (divs.length != 0) 
        {
            for (divcounter = 0 ; divcounter < divs.length ; divcounter++)
                {
                    var attribs = divs.item(divcounter).attributes;
                    var classAtr = attribs.getNamedItem("class");
                    if (classAtr && (itemtest.test(classAtr.nodeValue))) {
                        items[itemcounter] = divs[divcounter].id;
                        itemcounter++;
                    }
                }
            if (items.length != 0)
                {
                    // Build the hintcounter array from the array of items.
                    // Each subarray in hintcounter has item id as [0], and 0 as [1]
                    // because no hints have been displayed yet.
                    for (itemcounter = 0 ; itemcounter < items.length ; itemcounter++)
                        {
                            var theid = items[itemcounter];
                            hintcounter[itemcounter] = {id:theid, hintnum:0};
                        }
                }
        }
}
}

/*
 * showHint calls getHintCounter, which returns and augments the number
 * of the hint to be displayed next, and then displays that hint.   
 */
function showHint(item_id) 
{
    // Get all the items
    var thehint = getHintCounter(item_id);
    var thedivs = document.getElementById(item_id).getElementsByTagName('div');

    divcount = 0;
    hintcount = 0;
    hints = new Array();
    while (divcount < thedivs.length)
        {

            var ahint = /hint/;
            if (ahint.test(thedivs[divcount].id))
                {
                    hints[hintcount] = thedivs[divcount];
                    hintcount++;
                }
            divcount++;
        }

    if (hints[thehint]) {
        hints[thehint].style.display = 'block';
    }
}


/*
 * getHintCounter finds, returns, and augments the number of the hint
 * to be displayed next.  
 */
function getHintCounter(item_id)
{
    counternum = 0;
    while (counternum < hintcounter.length)
        {
            var hintid = hintcounter[counternum].id;
            if (hintid == item_id)
                {
                    return hintcounter[counternum].hintnum++;
                }
            counternum++;
        }
}




